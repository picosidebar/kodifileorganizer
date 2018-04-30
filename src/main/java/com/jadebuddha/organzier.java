package com.jadebuddha;

import com.google.gson.Gson;
import com.jadebuddha.omdb.Response;
import org.apache.commons.io.FilenameUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class organzier {

        private static final String[] BAD_EXTENSIONS = {"jpg","txt"};
        private static final String[] BAD_FILES = {"sample.avi"};
        private static final String OMDBApiKey = "a242616b";
        private static final String OMDBUrl = "http://www.omdbapi.com/";
        private static final File logFile = new File("x:/test/movie_machine.log");
        private static final File errorLogFile = new File("x:/test/movie_machine_error.log");

        private static List<File> directories = new ArrayList<>();

        public static void main(String[] args) {
            File[] files = new File("x:/test/").listFiles();


            assert files != null;
            for (File file : files) {
                if(file.isDirectory()) {
                    directories.add(file);
                }
            }
            processDirectories(directories);
//        showFiles(files);
        }

        private static void processDirectories(List<File> directories) {

            logInformation("Directories");
            logInformation("----------------------------------------------------------------------");
            for(File directory : directories) {
                logInformation(directory.getName());
                if(!doesNFOFileExist(directory)) {
                    logInformation("NFO file does not exist for "+directory.getName()+ " attempting to create one");
                    createNFOFile(directory);
                }
                populateNFOFile(directory);
            }
        }

        private static void populateNFOFile(File directory) {
            File nfoFile = getNFOFileExist(directory);
            String  result = fetchDataFromOMDB(directory.getName());
            String str = "Hello";
            writeToFile(nfoFile,str);

        }

        private static String fetchDataFromOMDB(String movieName) {

            String testName = movieName.replaceAll("\\(\\d\\d\\d\\d\\)", "").trim();
            String result = "";
            logInformation("Searchign OMDB for :"+testName);
            try {
                result = fetchContentByDirectoryName(URLEncoder.encode(testName));

                Gson g = new Gson();
                Response p = g.fromJson(result, Response.class);


                if("{\"Response\":\"False\",\"Error\":\"Movie not found!\"}".equals(result)) {
                    logError(testName+ " NOT FOUND");
                } else {
                    logInformation(result);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }

        private static boolean doesNFOFileExist(File directory) {
            for(File file : Objects.requireNonNull(directory.listFiles())) {
                if("nfo".equals(FilenameUtils.getExtension(file.getName()))) {
                    return true;
                }
            }
            return false;
        }

        private static File getNFOFileExist(File directory) {
            for(File file : Objects.requireNonNull(directory.listFiles())) {
                if("nfo".equals(FilenameUtils.getExtension(file.getName()))) {
                    return file;
                }
            }
            return null;
        }

        private static void  printDirectories(List<File> directories) {
            logInformation("Directories");
            logInformation("----------------------------------------------------------------------");
            for(File directory : directories) {
                logInformation(directory.getName());
                createNFOFile(directory);
            }
        }

        private static void  createNFOFile(File directory) {
            logInformation("Creating media.nfo for "+directory.getName());
            String nfoFilePath = directory.toPath() + "/media.nfo";
            File newFile = new File(nfoFilePath);
            try {
                newFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public static void showFiles(File[] files) {
            for (File file : files) {
                if (file.isDirectory()) {
                    logInformation("Directory: " + file.toPath());
                    if(".thumb".equals(file.getName())) {
                        logInformation("Deleting directory: "+file.getName());
                        file.delete();
                    } else {
                        showFiles(file.listFiles()); // Calls same method again.
                    }
                } else {
                    String extension = FilenameUtils.getExtension(file.getName());
                    if(stringContainsItemFromList(extension, BAD_EXTENSIONS) || stringContainsItemFromList(file.getName(), BAD_FILES)) {
                        logInformation("Deleting file: "+file.getName());
                        try {
                            Files.delete(file.toPath());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            logInformation(fetchContentByDirectoryName(file.getName()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        private static void deleteUneededFiles() {

        }

        private static String prepareFileName(String fileName) {
            String newFileName;
            newFileName = fileName.replace("."," ");
            newFileName = newFileName.substring(0,newFileName.length()/2);
            return URLEncoder.encode(newFileName);
        }

        public static boolean stringContainsItemFromList(String inputStr, String[] badStrings) {
            return Arrays.stream(badStrings).parallel().anyMatch(inputStr::contains);
        }

        private static String fetchContentByDirectoryName(String directoryName) throws IOException {

            String uri = OMDBUrl + "?apikey=" + OMDBApiKey + "&s=";
            uri += directoryName;
            logInformation("uri: "+uri);

            final int OK = 200;
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            int responseCode = connection.getResponseCode();
            if(responseCode == OK){
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                return response.toString();
            }

            return null;
        }

        private static void logError(String info) {
            System.out.println(info);
            if(!errorLogFile.exists()) {
                createFile(errorLogFile);
            }

            writeToFile(errorLogFile,info);
        }

        private static void logInformation(String info) {

            System.out.println(info);
            if(!logFile.exists()) {
                createFile(logFile);
            }

            writeToFile(logFile,info);

        }

        private static void createFile(File file) {
            try {
                file.createNewFile();
                logInformation("Creating file: "+file.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static void writeToFile(File file, String data) {
            try {
                assert file != null;
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file,true))) {
                    writer.newLine();
                    writer.write(data);
                    writer.flush();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    protected <T> String getResponseXML(T requestXml, Class clazz, String webserviceUrl) throws JAXBException {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
               RestTemplate restTemplate = new RestTemplate();
               JAXBContext jaxbContext;
               StringWriter stringWriter = new StringWriter();
                jaxbContext = JAXBContext.newInstance(clazz);
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
                marshaller.marshal(requestXml,stringWriter );
                String result = stringWriter.toString();
                HttpEntity<String> request = new HttpEntity<>(result, headers);
                final ResponseEntity<String> response = restTemplate.postForEntity(webserviceUrl, request, String.class);
                return response.getBody();
            }
    }
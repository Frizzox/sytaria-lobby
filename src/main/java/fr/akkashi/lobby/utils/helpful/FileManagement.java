package fr.akkashi.lobby.utils.helpful;

import fr.akkashi.lobby.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.*;
import java.util.logging.Logger;

public enum FileManagement {

    CONFIG("config.yml");

    private final String fileName;
    private final File dataFolder;

    FileManagement(String fileName) {
        this.fileName = fileName;
        this.dataFolder = Main.getInstance().getDataFolder();
    }

    public void create(Logger logger){
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("The file can not be empty...");
        }

            InputStream in = Main.getInstance().getResource(fileName);
        if (in == null) {
            throw new IllegalArgumentException("The file '" + fileName + "' has not been found in the jar plugin");
        }

        if (!dataFolder.exists() && !dataFolder.mkdir()) {
            logger.severe("Failed to create the file...");
        }

        File outFile = getFile();

        try {
            if(!outFile.exists()){
                logger.info("The file '"+ fileName +"' has not been found, creating it.");

                OutputStream out = new FileOutputStream(outFile);
                byte[] buf = new byte[1024];
                int n;

                while((n = in.read(buf)) >= 0){
                    out.write(buf, 0, n);
                }

                out.close();
                in.close();

                if(!outFile.exists()) {
                    logger.severe("Failed to copy the file");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getFile(){
        return new File(dataFolder, fileName);
    }

    public FileConfiguration getConfig(){
        return YamlConfiguration.loadConfiguration(getFile());
    }

    public String getFileName(){
        return fileName;
    }
}


package ru.stqa.pft.mantis.appmanager;

import org.apache.commons.net.ftp.FTPClient;
import sun.net.ftp.FtpClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FtpHelper extends HelperBase{

    private FTPClient ftp;

    public FtpHelper(ApplicationManager app){
        super(app);
        ftp = new FTPClient();
    }

    public void upload(File file, String target, String backup) throws IOException {
        ftp.connect(app.getProperty("ftp.host"));
        ftp.login(app.getProperty("ftp.login"), app.getProperty("ftp.password"));
        ftp.deleteFile(backup);
        ftp.rename(target, backup);
        ftp.enterLocalPassiveMode();
        ftp.storeFile(target, new FileInputStream(file));
        ftp.disconnect();
    }

    public void restore(String backup, String target) throws IOException {
        ftp.connect(app.getProperty("ftp.host"));
        ftp.login(app.getProperty("ftp.login"), app.getProperty("ftp.password"));
        ftp.deleteFile(target);
        ftp.rename(backup, target);
        ftp.disconnect();
    }


}

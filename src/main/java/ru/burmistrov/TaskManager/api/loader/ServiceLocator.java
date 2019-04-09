package ru.burmistrov.TaskManager.api.loader;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;

public interface ServiceLocator {

    void init() throws IOException, ParseException, NoSuchAlgorithmException, SQLException;

}

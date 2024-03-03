package basedate.dataaccess;

import org.example.domain.contract.Contract;
import org.example.exception.ValidatorDataBase;

import java.sql.Connection;
import java.sql.SQLException;

public interface Loader<T>{
    void  loader(T e, Connection connection) throws SQLException, ValidatorDataBase;
}

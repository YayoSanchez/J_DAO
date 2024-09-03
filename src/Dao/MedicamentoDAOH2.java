package Dao;

import Model.Medicamento;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MedicamentoDAOH2 implements iDao<Medicamento>{
private static final Logger logger = Logger.getLogger(MedicamentoDAOH2.class);
private final String SQL_INSERT = "INSERT INTO MEDICAMENTOS VALUES(?,?,?,?,?,?)";
private final String BUSCAR_PORID = "SELECT * FROM MEDICAMENTOS WHERE id = ?";
    @Override
    public Medicamento guardar(Medicamento medicamento) {
        Connection connection = null;
        try{
            connection = BD.getConnection();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
            psInsert.setInt(1,medicamento.getId());
            psInsert.setString(2, medicamento.getNombre());
            psInsert.setInt(3,medicamento.getCodigoNumerico());
            psInsert.setString(4, medicamento.getLaboratorio());
            psInsert.setDouble(5,medicamento.getPrecio());
            psInsert.setInt(6,medicamento.getCantidad());
            psInsert.execute();
            logger.info("datos cargados con exito");
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return medicamento;
    }

    @Override
    public Medicamento buscarporID(Integer id) {
        Connection connection = null;
        Medicamento medicamento = null;
        try{
            connection = BD.getConnection();
            PreparedStatement buscarPorID = connection.prepareStatement(BUSCAR_PORID);

            buscarPorID.setInt(1,id);
            ResultSet resultSet = buscarPorID.executeQuery();

            while(resultSet.next()){
                medicamento = new Medicamento();
                medicamento.setId(resultSet.getInt("id"));
                medicamento.setNombre(resultSet.getString("nombre"));
                medicamento.setCodigoNumerico(resultSet.getInt("codigo_numerico"));
                medicamento.setLaboratorio(resultSet.getString("laboratorio"));
                medicamento.setPrecio(resultSet.getDouble("precio"));
                medicamento.setCantidad(resultSet.getInt("cantidad"));
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return medicamento;
    }
}

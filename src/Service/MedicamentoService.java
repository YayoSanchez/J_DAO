package Service;

import Dao.MedicamentoDAOH2;
import Dao.iDao;
import Model.Medicamento;

public class MedicamentoService {
    private iDao<Medicamento> medicamentoiDao;

    public MedicamentoService() {
        medicamentoiDao = new MedicamentoDAOH2();
    }
    public Medicamento guardarMedicamento(Medicamento medicamento){
        return medicamentoiDao.guardar(medicamento);
    }
    public Medicamento buscarMedicamentoPorID(Integer id){
        return medicamentoiDao.buscarporID(id);
    }
}

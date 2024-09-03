import Dao.BD;
import Model.Medicamento;
import Service.MedicamentoService;

public class Cliente {
    public static void main(String[] args) {
        Medicamento medicamento = new Medicamento(1,"Ibuprofeno",123,"Bayer",10.0,10);
        BD.crearTabla();
        MedicamentoService medicamentoService = new MedicamentoService();
        medicamentoService.guardarMedicamento(medicamento);
    }
}

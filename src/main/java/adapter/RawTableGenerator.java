package adapter;

public class RawTableGenerator {

    public static void main(String args[]){
        Adapter adapter = new DirectReportAdapter();
        adapter.generateRawTable();
    }

}

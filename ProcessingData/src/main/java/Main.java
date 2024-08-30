
public class Main {
    public static void main(String[] args){
        if(args.length !=2){
            System.out.println("Validate command: 'java -jar app_name.jar <Function Name> testData.json'");
            return;
        }

        String functionName = args[0];
        String filePath = args[1];

        try {
            ExecuteService service = new ExecuteService();
            // Выполнение статистической функции
            String result = service.executeFunction(functionName, filePath);
            System.out.println(functionName + ": "+ result);
        }
        catch (Exception e){
            System.out.println("Exeption:" + e);
        }


    }
}

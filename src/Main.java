public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        if (args.length>0){
            new server.Main().run();
            return;
        }
        new client.Main().run();
    }
}

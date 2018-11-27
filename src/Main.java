public class Main {

    public static void main(String[] args) {
        TelevisionRemote oneForAll = new TelevisionRemote(1,35,2,90,24,18);

        oneForAll.goToChannel();
        System.out.println(oneForAll.getCurrentChannel());
    }
}

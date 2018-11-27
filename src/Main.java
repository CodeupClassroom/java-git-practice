public class Main {
    public static void main(String[] args) {
        TelevisionRemote tvremote = new TelevisionRemote(2, 100,12, 15,1, 30);
        try {
            tvremote.goToChannel(76);
        }catch (ChannelOutOfBoundsException e){
            e.printStackTrace();
        }
        System.out.println(tvremote.getCurrentChannel());
    }
}

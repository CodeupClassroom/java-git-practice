public class Main {
    public static void main(String[] args) {
        Remote teleRemote = new TelevisionRemote(1,10, 1, 20, 3, 4);
        teleRemote.channelDown();
        System.out.println(teleRemote.getChannel());
        teleRemote.channelUp();
        teleRemote.channelUp();
        System.out.println(teleRemote.getChannel());

        System.out.println(teleRemote.getVolume());
        teleRemote.volumeDown();
        System.out.println(teleRemote.getVolume());
        teleRemote.volumeUp();
        teleRemote.volumeUp();
        System.out.println(teleRemote.getVolume());

        try {
            teleRemote.goToChannel(70);
        } catch (ChannelOutOfBoundsException e) {
            e.printStackTrace();
        }
        System.out.println(teleRemote.getChannel());

    }


}

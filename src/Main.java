public class Main {

    public static void main(String[] args) {
        TelevisionRemote test = new TelevisionRemote(1, 10, 1, 15, 6, 8);


        try {
            test.goToChannel(16);
        } catch (ChannelOutOfBoundsException e) {
            e.printStackTrace();
        }

        try {
            test.goToChannel(0);
        } catch (ChannelOutOfBoundsException e) {
            e.printStackTrace();
        }

        try {
            test.goToChannel(3);
            System.out.println(test.getCurrentChannel());
        } catch (ChannelOutOfBoundsException e) {
            e.printStackTrace();
        }

        test.volumeUp();
        System.out.println(test.getCurrentVolume());
        test.volumeDown();
        System.out.println(test.getCurrentVolume());

        test.channelUp();
        System.out.println(test.getCurrentChannel());
        test.channelDown();
        System.out.println(test.getCurrentChannel());

    }
}

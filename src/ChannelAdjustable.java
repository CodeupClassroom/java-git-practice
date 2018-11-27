public interface ChannelAdjustable {

    void channelUp();

    void channelDown();

    void goToChannel (int channelNumber) throws ChannelOutOfBoundsException;

}
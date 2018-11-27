public interface ChannelAdjustable {
    void channelUp();
    void channelDown();
    void goToChannel() throws ChannelOutOfBoundsException;
}

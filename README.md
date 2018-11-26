# Java Project Practice Repo

This repository is intended to practice cloning a Java project and running it in IntelliJ. Additionally, this repo contains to dos which will encompass material covered in the Java II module.

### Basic Git Practice

Please clone this repo, open the project in IntelliJ, and follow the TODOs written in the Main class.

### Java II Review

1. Empty out the TODOS in the Main class
1. Create an interface called ChannelAdjustable with three void methods (channelUp(), channelDown(), goToChannel(int channelNumber)). goToChannel() should have a throws clause for the ChannelOutOfBoundsException.
1. Create another interface called VolumeAdjustable with two void methods (volumeUp(), volumeDown())
1. Create an abstract class called Remote that implements ChannelAdjustable and VolumeAdjustable and contains private properties for int currentVolume and int currentChannel and add getters and setters and constructors
1. Create a class TelevisionRemote that extends Remote and contains two hashmap properties...
 
     ```
     private HashMap<String, Integer> minMaxVolume;
     private HashMap<String, Integer> minMaxChannel;
    
    ```
 
1. Add a constructor that takes in six integers (minVolume, maxVolume, minChannel, maxChannel, initialChannel, initialVolume) and sets both the hash map properties as empty hash maps and adds two key-value pairs to both hash maps to set the "min" and "max" keys to the appropriate int values. Be sure to use the parent constructor to set the initialVolume and initialChannel properties.
1. Implement all methods (the up and down methods of volume and channel should raise their respective int values up or down by 1 but not change the value at all if trying to exceed the min or max values). The goToChannel() should throw the ChannelOutOfBoundsException if the channel is not in the correct range.
1. In the Main class, add a main method and test creating a TelevisionRemote object and adjusting the volume and channels and sout'ing out the various property values. You will need to surround calls to goToChannel() in a try-catch block.

 
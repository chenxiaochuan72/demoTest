package javaguidetest.iotest;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author cxc
 * @Date 2023/7/2 7:04 PM
 * @Version 1.0
 * @Description:
 */

public class FileIOTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File("input.txt"), "rw");
        FileChannel channel = randomAccessFile.getChannel();
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        channel.read(allocate);
        allocate.flip();
        new BufferedInputStream(new FileInputStream("input.txt"));
    }

}

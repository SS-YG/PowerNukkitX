package cn.nukkit.level;

import cn.nukkit.block.BlockAir;
import cn.nukkit.block.BlockOakLog;
import cn.nukkit.block.BlockState;
import cn.nukkit.block.BlockWoodenButton;
import cn.nukkit.level.format.IChunk;
import cn.nukkit.level.format.LevelDBProvider;
import cn.nukkit.level.format.palette.Palette;
import cn.nukkit.registry.Registries;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;


public class LevelStorageTest {
    static LevelDBProvider levelDBProvider;

    @BeforeAll
    @SneakyThrows
    static void before() {
        Registries.BLOCK.init();
        FileUtils.copyDirectory(new File("src/test/resources/level"), new File("src/test/resources/level2"));
        levelDBProvider = new LevelDBProvider(null, "src/test/resources/level2");
        levelDBProvider.initDimensionData(DimensionEnum.OVERWORLD.getDimensionData());
    }

    @AfterAll
    @SneakyThrows
    static void after() {
        levelDBProvider.close();
        FileUtils.deleteDirectory(new File("src/test/resources/level2"));
    }


    static byte[] SECTION = new byte[]{9, 1, -4, 6, 64, -110, 36, 9, 73, -110, 0, 8, 73, -110, 36, 9, 9, 0, 32, 9, 73, -110, 36, 0, 0, -110, 36, 9, 73, 2, -32, 9, 73, -110, 36, 9, 0, -98, 36, 9, 73, -110, 0, 63, 73, -110, 36, 9, 9, 0, 36, 9, 73, -110, 36, 0, 127, -110, 36, 9, 73, 2, 0, 9, 73, -110, 36, 9, 0, -112, 36, 9, 73, -110, 0, 0, 72, -110, 36, 9, 9, -112, 36, 9, 73, -110, 36, 0, 72, -110, 36, 9, 73, 2, 32, 9, 73, -110, 36, 9, 0, -110, 36, 9, 73, -110, 0, 0, 72, -110, 36, 9, 9, 0, 32, 9, 73, -110, 36, 0, 64, -110, 36, 9, 73, 2, 0, 8, 73, -110, 36, 9, 0, -112, 36, 9, 73, -110, 0, 63, 79, -110, 36, 9, 9, 0, 32, 9, 73, -110, 36, 0, 0, -110, 36, 9, 73, 2, 0, 15, 73, -110, 36, 9, 64, -1, 36, 9, 73, -110, 0, 56, 79, -110, 36, 9, 9, 0, 32, 9, 73, -110, 36, 0, 0, -110, 36, 9, 73, 2, -4, 9, 73, -110, 36, 9, 0, -128, 36, 9, 73, -38, 0, 0, 72, -110, 36, 9, 9, 0, 32, 9, 73, -110, 36, 0, 64, -110, 36, 9, 73, 2, 36, 9, 9, -103, 36, 9, 0, -110, 36, 36, 73, -110, 0, 0, 73, 66, 38, 9, 9, -16, 39, 9, 73, -110, 36, 0, 0, -110, 36, 9, 73, 2, -32, 15, 73, -110, 36, 9, 0, -16, 39, 9, 73, -110, 0, 61, 127, -110, 36, 9, 9, -128, -1, 9, 73, -110, 36, 0, -8, -109, 36, 9, 73, 2, 0, 8, 73, -110, 36, 9, 0, -128, 36, 9, 73, -110, 0, 0, 73, -110, 36, 9, 9, 0, 32, 9, 73, -110, 36, 0, 64, -110, 36, 9, 73, 2, 32, 9, 73, -110, 36, 9, 0, -110, 36, 36, 73, -110, 0, 9, 73, 72, 38, 9, 9, -16, 36, 33, 36, -109, 36, 0, 127, 18, -110, 9, 73, 2, 0, 8, 9, -103, 36, 9, 0, -128, 36, 9, 73, -110, 0, 63, 127, -110, 36, 9, 9, -16, -1, 9, 73, -110, 36, 0, 0, -98, 36, 9, 73, 2, 0, 56, 73, -110, 36, 9, 0, -128, 39, 9, 73, -110, 0, 56, 79, -110, 36, 9, 9, -128, 63, 9, 73, -110, 36, 0, 120, -110, 36, 9, 73, 2, 32, 9, 73, -110, 36, 9, 64, -110, 36, 9, 73, -110, 0, 8, 73, 66, 38, 9, 9, -112, 100, 33, 36, -109, 36, 0, 64, 66, -110, 12, 73, 2, 0, 9, 36, -55, 36, 9, 0, -98, -124, 36, 76, -110, 0, 0, 79, 72, 38, 9, 9, -128, -1, 9, 73, -110, 36, 0, 0, -98, 36, 9, 73, 2, -32, 63, 73, -110, 36, 9, -64, -1, 39, 9, 73, -110, 0, 0, 127, -110, 36, 9, 9, 0, 60, 9, 73, -110, 36, 0, 0, -110, 36, 9, 73, 2, 0, 15, 73, -110, 36, 9, 0, -112, 36, 9, 73, -110, 0, 0, 72, -110, 36, 9, 9, 0, 32, 27, 73, -110, 36, 0, 64, 18, -110, 9, 73, 2, 0, 8, 36, -55, 36, 9, 0, -110, -112, 36, 76, -110, 0, 0, 8, 73, 50, 9, 9, -128, 63, 36, 36, -109, 36, 0, -8, 19, 50, 9, 73, 2, 0, 15, 73, -110, 36, 9, 0, -128, 39, 9, 73, -110, 0, 0, 120, -110, 36, 9, 9, 0, -32, 9, 73, -110, 36, 0, -1, -97, 36, 9, 73, 2, -4, 63, 73, -110, 36, 9, 0, -128, 36, 9, 73, -110, 0, 0, 73, -110, 36, 9, 9, -112, 36, 9, 73, -110, 36, 0, 73, -110, 36, 9, 73, 2, 0, 9, 33, -103, 36, 9, 0, -110, -124, 36, 76, -110, 0, 0, 8, 73, 50, 9, 9, 0, 36, 36, 36, -109, 36, 0, 120, 66, -110, 12, 73, 2, -4, 15, 33, -103, 36, 9, 0, -128, 36, 9, 73, -110, 0, 63, 79, -110, 36, 9, 9, 0, -4, 9, 73, -110, 36, 0, -1, -109, 36, 9, 73, 2, -4, 63, 73, -110, 36, 9, 0, -16, 36, 9, 73, -110, 0, 63, 79, -110, 36, 9, 9, -128, 36, 9, 73, -110, 36, 0, 73, -110, 36, 9, 73, 2, 32, 9, 73, -110, 36, 9, 0, -110, 36, 9, 73, -110, 0, 49, 78, 72, 38, 9, 9, 16, 59, 36, 36, -109, 36, 0, 72, 66, -110, 12, 73, 2, 32, 9, 36, -103, 36, 9, -64, -109, -112, 36, 73, -110, 0, 0, 73, -56, 36, 9, 9, -128, 63, 9, 73, -110, 36, 0, -8, -109, 36, 9, 73, 2, -4, 15, 73, -110, 36, 9, 0, -128, 36, 9, 73, -110, 0, 56, 79, -110, 36, 9, 9, -128, 63, 9, 73, -110, 36, 0, 72, -110, 36, 9, 73, 2, 36, 9, 73, -110, 36, 9, 0, -128, 36, 9, 73, -110, 0, 0, 73, -110, 36, 9, 9, 0, 36, 9, 73, -110, 36, 0, 0, -110, 48, 9, 73, 2, 0, 8, 33, -103, 36, 9, 0, -110, -112, 36, 73, -110, 0, 0, 8, 73, 38, 9, 9, -112, 36, 33, 76, -110, 36, 0, 120, -110, 36, 9, 73, 2, 0, 8, 73, -110, 36, 9, 0, -128, 36, 9, 73, -110, 0, 0, 79, -110, 36, 9, 9, 0, 60, 9, 73, -110, 36, 0, -64, -109, 36, 9, 73, 2, 32, 10, 73, -110, 36, 9, 0, -128, 36, 9, 73, -110, 0, 9, 74, -110, 36, 9, 9, -112, 36, 9, -55, -110, 36, 0, 64, -110, 36, 9, 73, 2, 0, 8, 73, -110, 36, 9, 0, -110, 36, 9, 73, -110, 0, 0, 72, -56, 36, 9, 9, 0, 36, 33, 76, -110, 36, 0, 0, 18, 50, 9, 73, 2, 0, 8, 73, -110, 36, 9, 0, -128, 36, 9, 73, -110, 0, 15, 73, -110, 36, 9, 9, -128, 39, 9, 73, -110, 36, 0, 0, -110, 36, 9, 73, 2, -32, 9, 73, -110, 36, 9, 0, 34, 37, 9, 73, -110, 0, 0, 80, -110, 36, 9, 9, 0, 72, 9, 73, -110, 36, 0, -119, -110, 36, 9, 73, 2, 0, 8, 73, -110, 37, 9, 0, -112, 36, 9, 73, -110, 0, 8, 73, -110, 36, 9, 9, 0, 32, 9, 73, -110, 36, 0, 72, -110, 36, 9, 73, 2, 36, 9, 73, -110, 36, 9, 0, -112, 36, 9, 73, -110, 0, 8, 73, -110, 36, 9, 11, -112, 36, 9, 73, -110, 36, 0, 73, -110, 36, 9, 73, 2, 0, 8, 73, -110, 36, 9, 0, -110, 36, 9, 73, -110, 0, 8, -110, -110, 36, 9, 9, -112, 72, 10, 73, -110, 36, 0, -119, -108, 36, 9, 73, 2, 32, 18, 73, -110, 36, 9, 64, 18, 37, 9, 73, -110, 0, 9, 73, -110, 36, 9, 9, -112, 36, 9, 73, -110, 36, 0, 73, -110, 36, 9, 73, 2, 32, 9, 73, -110, 36, 9, 0, -128, 36, 9, 73, -109, 0, 0, 72, -110, 36, 9, 9, 0, 36, 9, 73, -110, 100, 0, 72, -110, 36, 9, 73, 6, 0, 9, 73, -110, 36, 9, 0, -56, 36, 9, 73, -110, 0, 32, 100, -110, 36, 9, 9, -128, 72, 9, 73, -110, 36, 0, -119, -92, 36, 9, 73, 2, 32, 18, 74, -110, 36, 9, 0, 32, 41, 9, 73, -110, 0, 0, -112, -110, 36, 9, 9, 0, 64, 9, 73, -110, 36, 0, 0, -108, 36, 9, 73, 2, 0, 9, 73, -110, 36, 9, 0, -112, 36, 9, 73, -110, 0, 0, 73, -110, 36, 13, 9, 0, 32, 9, 73, -110, 36, 0, 72, -110, 36, 9, 73, 2, -128, 12, 73, -110, 36, 9, 0, 72, 38, 9, 73, -110, 0, 32, 100, -110, 36, 9, 9, 64, -110, 9, 73, -110, 36, 0, 72, -108, 36, 9, 73, 2, 0, 16, 74, -46, 36, 9, 0, 34, 73, 9, 73, -110, 0, 9, -110, -108, 36, 9, 9, 0, 64, 18, 73, -110, 36, 0, 64, -92, 36, 9, 73, 2, 0, 17, 73, -110, 36, 9, 64, -110, 36, 9, 73, -110, 0, 0, 72, -110, 36, 9, 9, -112, 36, 9, 73, -110, 36, 0, 0, -110, 36, 9, 73, 2, 0, 8, 73, -110, 36, 9, 0, 0, 38, 9, 73, -110, 0, 0, 96, -110, 36, 9, 9, 0, -128, 9, 73, -110, 36, 0, 32, -103, 36, 9, 73, 2, 32, 9, 73, -110, 36, 9, 64, -110, 40, 9, 77, -110, 0, 9, -111, -108, 36, 9, 9, -112, 68, 18, 73, -110, 36, 0, 72, 36, 37, 9, 73, 2, 0, 17, 82, -110, 36, 9, 0, 16, 41, 9, 73, -110, 0, 9, -119, -110, 36, 9, 9, -112, 36, 9, 73, -110, 36, 0, 0, -110, 36, 9, 73, 2, 0, 8, 73, -110, 36, 9, 0, 73, 38, 9, 73, -110, 0, 32, 100, -110, 36, 9, 9, 64, -110, 9, 73, -110, 36, 0, 0, -104, 36, 9, 73, 2, -128, 36, 73, -110, 36, 9, 64, -110, 36, 9, 73, -110, 0, 9, 73, -110, 36, 9, 9, 0, 36, 18, 73, -110, 36, 0, 73, 34, 37, 9, 73, 2, 32, 17, 82, -110, 36, 9, 0, 0, 73, 10, 73, -110, 0, 8, -111, -108, 36, 9, 9, -128, 36, 10, 73, -110, 36, 0, 0, -94, 36, 9, 73, 2, 32, 9, 113, -110, 36, 9, 0, -128, -60, 14, 73, -110, 0, 36, 76, -110, 36, 9, 41, 0, -112, 9, 73, -110, 36, 0, 0, -104, 36, 9, 73, 2, 0, 36, 73, -110, 36, 9, 0, -56, 36, 9, 73, -110, 0, 0, 8, 0, 0, 0, 10, 0, 0, 8, 4, 0, 110, 97, 109, 101, 17, 0, 109, 105, 110, 101, 99, 114, 97, 102, 116, 58, 98, 101, 100, 114, 111, 99, 107, 10, 6, 0, 115, 116, 97, 116, 101, 115, 1, 14, 0, 105, 110, 102, 105, 110, 105, 98, 117, 114, 110, 95, 98, 105, 116, 0, 0, 3, 7, 0, 118, 101, 114, 115, 105, 111, 110, 1, 50, 20, 1, 0, 10, 0, 0, 8, 4, 0, 110, 97, 109, 101, 19, 0, 109, 105, 110, 101, 99, 114, 97, 102, 116, 58, 100, 101, 101, 112, 115, 108, 97, 116, 101, 10, 6, 0, 115, 116, 97, 116, 101, 115, 8, 11, 0, 112, 105, 108, 108, 97, 114, 95, 97, 120, 105, 115, 1, 0, 121, 0, 3, 7, 0, 118, 101, 114, 115, 105, 111, 110, 1, 50, 20, 1, 0, 10, 0, 0, 8, 4, 0, 110, 97, 109, 101, 14, 0, 109, 105, 110, 101, 99, 114, 97, 102, 116, 58, 108, 97, 118, 97, 10, 6, 0, 115, 116, 97, 116, 101, 115, 3, 12, 0, 108, 105, 113, 117, 105, 100, 95, 100, 101, 112, 116, 104, 0, 0, 0, 0, 0, 3, 7, 0, 118, 101, 114, 115, 105, 111, 110, 1, 50, 20, 1, 0, 10, 0, 0, 8, 4, 0, 110, 97, 109, 101, 28, 0, 109, 105, 110, 101, 99, 114, 97, 102, 116, 58, 100, 101, 101, 112, 115, 108, 97, 116, 101, 95, 105, 114, 111, 110, 95, 111, 114, 101, 10, 6, 0, 115, 116, 97, 116, 101, 115, 0, 3, 7, 0, 118, 101, 114, 115, 105, 111, 110, 1, 50, 20, 1, 0, 10, 0, 0, 8, 4, 0, 110, 97, 109, 101, 16, 0, 109, 105, 110, 101, 99, 114, 97, 102, 116, 58, 103, 114, 97, 118, 101, 108, 10, 6, 0, 115, 116, 97, 116, 101, 115, 0, 3, 7, 0, 118, 101, 114, 115, 105, 111, 110, 1, 50, 20, 1, 0, 10, 0, 0, 8, 4, 0, 110, 97, 109, 101, 31, 0, 109, 105, 110, 101, 99, 114, 97, 102, 116, 58, 100, 101, 101, 112, 115, 108, 97, 116, 101, 95, 100, 105, 97, 109, 111, 110, 100, 95, 111, 114, 101, 10, 6, 0, 115, 116, 97, 116, 101, 115, 0, 3, 7, 0, 118, 101, 114, 115, 105, 111, 110, 1, 50, 20, 1, 0, 10, 0, 0, 8, 4, 0, 110, 97, 109, 101, 32, 0, 109, 105, 110, 101, 99, 114, 97, 102, 116, 58, 100, 101, 101, 112, 115, 108, 97, 116, 101, 95, 114, 101, 100, 115, 116, 111, 110, 101, 95, 111, 114, 101, 10, 6, 0, 115, 116, 97, 116, 101, 115, 0, 3, 7, 0, 118, 101, 114, 115, 105, 111, 110, 1, 50, 20, 1, 0, 10, 0, 0, 8, 4, 0, 110, 97, 109, 101, 14, 0, 109, 105, 110, 101, 99, 114, 97, 102, 116, 58, 116, 117, 102, 102, 10, 6, 0, 115, 116, 97, 116, 101, 115, 0, 3, 7, 0, 118, 101, 114, 115, 105, 111, 110, 1, 50, 20, 1, 0};
    static byte[] AIR = new byte[]{10, 5, 0, 66, 108, 111, 99, 107, 8, 4, 0, 110, 97, 109, 101, 13, 0, 109, 105, 110, 101, 99, 114, 97, 102, 116, 58, 97, 105, 114, 10, 6, 0, 115, 116, 97, 116, 101, 115, 0, 0};

    @Test
    void testLevelDatLoad() {
        Assertions.assertNotNull(levelDBProvider.getLevelData());
        Assertions.assertEquals(4, levelDBProvider.getLevelData().getServerChunkTickRange());
    }

    @Test
    void testLoadChunk() {
        IChunk chunk = levelDBProvider.getChunk(0, 0);
        Assertions.assertNotNull(chunk);
        Assertions.assertEquals("minecraft:cauldron", chunk.getBlockState(0, 284, 0).getIdentifier());
    }

    @Test
    @SneakyThrows
    void testWriteChunk() {
        IChunk chunk = levelDBProvider.getChunk(0, 0);
        chunk.setBlockState(0, 50, 0, BlockOakLog.PROPERTIES.getDefaultState());
        levelDBProvider.writeChunk(chunk);
        chunk.setX(1);
        chunk.setZ(1);
        levelDBProvider.writeChunk(chunk);
        chunk.setX(2);
        chunk.setZ(2);
        levelDBProvider.writeChunk(chunk);
        IChunk c1 = levelDBProvider.getChunk(0, 0);
        IChunk c2 = levelDBProvider.getChunk(1, 1);
        IChunk c3 = levelDBProvider.getChunk(2, 2);
        Assertions.assertEquals("minecraft:oak_log", c1.getBlockState(0, 50, 0).getIdentifier());
        Assertions.assertEquals("minecraft:oak_log", c2.getBlockState(0, 50, 0).getIdentifier());
        Assertions.assertEquals("minecraft:oak_log", c3.getBlockState(0, 50, 0).getIdentifier());
    }

    @Test
    void testLoadPalette() {
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.ioBuffer();
        byteBuf.writeBytes(SECTION);
        byteBuf.readByte();//subchunk version 9
        byteBuf.readByte();//layer 2
        byteBuf.readByte();//section y -4
        Palette<BlockState> blockStatePalette = new Palette<>(BlockAir.STATE);
        blockStatePalette.readFromStoragePersistent(byteBuf, Registries.BLOCKSTATE::get);
    }

    @Test
    void testWritePalette() {
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.ioBuffer();
        byteBuf.writeByte(9);//subchunk version 9
        byteBuf.writeByte(2);//layer 2
        byteBuf.writeByte(-4);//section y -4
        Palette<BlockState> blockStatePalette = new Palette<>(BlockAir.STATE);
        blockStatePalette.writeToStoragePersistent(byteBuf, BlockState::getBlockStateTag);
        byte[] data = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(data);
        Assertions.assertEquals(4, data[3]);//Palette Header
        byte[] bytes = Arrays.copyOfRange(data, 4 + 1024, data.length);
        Assertions.assertArrayEquals(new byte[]{1, 0, 0, 0}, Arrays.copyOfRange(bytes, 0, 4));//Palette size
    }

    @SneakyThrows
    @Test
    void testSaveAndReadChunk() {
        IChunk chunk = levelDBProvider.getChunk(0, 0);
        Assertions.assertEquals("minecraft:cauldron", chunk.getBlockState(0, 284, 0).getIdentifier());
        chunk.setBlockState(0, 100, 0, BlockWoodenButton.PROPERTIES.getDefaultState());
        levelDBProvider.writeChunk(chunk);
        IChunk newChunk = levelDBProvider.readChunk(0, 0);
        Assertions.assertNotNull(newChunk);
        Assertions.assertEquals("minecraft:wooden_button", chunk.getBlockState(0, 100, 0).getIdentifier());
    }

    @Test
    @SneakyThrows
    void testCloseAndLoadAgain() {
        var newProvider = new LevelDBProvider(null, "src/test/resources/level3");
        newProvider.initDimensionData(DimensionEnum.OVERWORLD.getDimensionData());
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                IChunk chunk = newProvider.getChunk(i, j, true);
                for (int x = 0; x < 16; x++) {
                    for (int z = 0; z < 16; z++) {
                        chunk.setBlockState(x, 1, z, BlockOakLog.PROPERTIES.getDefaultState());
                    }
                }
            }
        }
        newProvider.close();
        newProvider = new LevelDBProvider(null, "src/test/resources/level3");
        newProvider.initDimensionData(DimensionEnum.OVERWORLD.getDimensionData());
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                newProvider.getChunk(i, j);
            }
        }
        newProvider.close();
        FileUtils.deleteDirectory(new File("src/test/resources/level3"));
    }
}
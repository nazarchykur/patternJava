package com.patternJava.structural.adapter.adapter_3;

public class AdapterEx {
    public static void main(String[] args) {
        // 1 спосіб = через наслідування
        VectorGraphics graphics = new VectorFromRasterAdapter();
        graphics.drawLine();
        graphics.drawSquare();

        // 2 спосіб = через композицію
        // якщо зразу ініціалізували поле
//        VectorGraphics graphics2 = new VectorFromRasterAdapter2();
        VectorGraphics graphics2 = new VectorFromRasterAdapter2(new RasterGraphics());
        graphics2.drawLine();
        graphics2.drawSquare();
    }
}

// клієнт працює з таким інтерфейсом
interface VectorGraphics {
    void drawLine();

    void drawSquare();
}

// наш клас, який вміє виконувати такі дії
class RasterGraphics {
    void drawRasterLine() {
        System.out.println("draw line ...");
    }

    void drawRasterSquare() {
        System.out.println("draw square ... ");
    }
}

class VectorFromRasterAdapter extends RasterGraphics implements VectorGraphics {
    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}

class VectorFromRasterAdapter2 implements VectorGraphics {
    // тут ми зразу вказали реалізацію від RasterGraphics
//    private final RasterGraphics rasterGraphics = new RasterGraphics();

    // тут ми можемо підставити потрібний клас і пізніше через конструктор передати
    private RasterGraphics rasterGraphics;

    public VectorFromRasterAdapter2(RasterGraphics rasterGraphics) {
        this.rasterGraphics = rasterGraphics;
    }

    @Override
    public void drawLine() {
        rasterGraphics.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        rasterGraphics.drawRasterSquare();
    }
}
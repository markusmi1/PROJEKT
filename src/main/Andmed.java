package main;

public interface Andmed {
    int blokiSuurus = 16;
    int kordaja = 3;
    int suurus = blokiSuurus * kordaja;   //ekrranil oleva bloki lõplik suurus
    int ekraaniKõrgus = suurus * 10;
    int ekraaniLaius = suurus * 15;
    // karakteri alguspunkt
    int xKoord = 100;
    int yKoord = 100;

}

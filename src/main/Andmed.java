package main;

public interface Andmed {
    int blokiSuurus = 16;
    int kordaja = 3;
    int suurus = blokiSuurus * kordaja;   //ekrranil oleva bloki lõplik suurus
    int ekraaniKõrgus = suurus * 10;
    int ekraaniLaius = suurus * 15;

    int staatus = 0;
    int algStaatus = 0;
    int peaMäng = 1;

    //menu
    int menuValik = 0;
}

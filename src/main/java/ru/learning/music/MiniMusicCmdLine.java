package ru.learning.music;

import javax.sound.midi.*;
import java.util.Scanner;

public class MiniMusicCmdLine {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int instrument = scanner.nextInt();
        System.out.println(instrument);
        int note = scanner.nextInt();
        System.out.println(note);

        MiniMusicCmdLine mini = new MiniMusicCmdLine();


        mini.play(instrument, note);


    }

    private void play(int instrument, int note) {
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            MidiEvent event = null;

            ShortMessage first = new ShortMessage();
            first.setMessage(192, 1, instrument, 0);
            MidiMessage midiMessage;
            MidiEvent changeInstrument = new MidiEvent(first, 1);
            track.add(changeInstrument);

            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, note, 100);
            MidiEvent noteOm = new MidiEvent(a, 1);
            track.add(noteOm);

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, note, 100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff);
            player.setSequence(seq);
            player.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

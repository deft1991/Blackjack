package com.deft.blackjack.service;

import com.deft.blackjack.model.PlayType;
import com.deft.blackjack.model.PlayerActionType;

import java.util.Scanner;

/**
 * @author Sergey Golitsyn
 * created on 07.09.2023
 */
public class InputServiceHelper {

    public static PlayerActionType askForCommand(Scanner scanner) {
        String command = scanner.nextLine();

        while (command.isBlank()){
            command = scanner.nextLine();
        }
        command = command.toUpperCase();

        while (!PlayerActionType.contains(command)){
            System.out.println("Available commands \"hit\", \"stand\"");
            command = scanner.nextLine();
            command = command.toUpperCase();
        }

        return PlayerActionType.valueOf(command);
    }

    public static PlayType askPlayAgain(Scanner scanner){
        String command = scanner.nextLine();

        while (command.isBlank()){
            command = scanner.nextLine();
        }
        command = command.toUpperCase();

        while (!PlayType.contains(command)){
            System.out.println("Available commands \"again\", \"exit\"");
            command = scanner.nextLine();
            command = command.toUpperCase();
        }

        return PlayType.valueOf(command);
    }

}

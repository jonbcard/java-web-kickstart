package org.card.kickstart

class ShellCommands {

    static String inputPrompt = "> "

    static String prompt(String message, String defaultValue = null) {
        String defaultString = defaultValue == null ? "" : "(${defaultValue})";
        return System.console().readLine("${inputPrompt} ${message} ${defaultString}:") ?: defaultValue
    }
}

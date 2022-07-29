package com.javarush.task.task14.task1408;

class BelarusianHen extends Hen {

    @Override
    int getCountOfEggsPerMonth() {
        return 30;
    }

    @Override
    String getDescription() {
        return String.format("%s Моя страна - %s. Я несу %s яиц в месяц.", super.getDescription(), Country.BELARUS, getCountOfEggsPerMonth());
    }
}

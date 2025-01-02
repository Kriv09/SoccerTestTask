package com.example.socertesttask.Utils;

import com.example.socertesttask.Models.SoccerPlayer;
import com.example.socertesttask.Models.SoccerTeam;
import com.example.socertesttask.Models.SoccerTransfer;

import java.math.BigDecimal;

public class TransferUtils {

    public static BigDecimal calculatePriceOfPlayer(SoccerPlayer player)
    {
        return BigDecimal.valueOf(player.getPlayExperience() * 100_000 / player.getAge());
    }

    public static BigDecimal calculateSumOfTransfer(SoccerPlayer player , SoccerTeam soccerTeam)
    {
        return calculatePriceOfPlayer(player).multiply(BigDecimal.valueOf(1 - ((100 - soccerTeam.getBoard()) / 100.0)));

    }


}

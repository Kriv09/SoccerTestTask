package com.example.socertesttask.Services;

import com.example.socertesttask.Models.Requests.SoccerTransferRequest;
import com.example.socertesttask.Models.SoccerPlayer;
import com.example.socertesttask.Models.SoccerTeam;
import com.example.socertesttask.Models.SoccerTransfer;
import com.example.socertesttask.Repositories.SoccerTransferRepository;
import com.example.socertesttask.Repositories.SoccerPlayerRepository;
import com.example.socertesttask.Repositories.SoccerTeamRepository;
import com.example.socertesttask.Utils.TransferUtils;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class SoccerTransferService {

    private final SoccerTransferRepository soccerTransferRepository;
    private final SoccerPlayerService soccerPlayerService;
    private final SoccerTeamService soccerTeamService;
    private static final Logger logger = LoggerFactory.getLogger(SoccerTransferService.class);

    @Autowired
    public SoccerTransferService(SoccerTransferRepository soccerTransferRepository,
                                 SoccerPlayerService soccerPlayerService,
                                 SoccerTeamService soccerTeamService) {
        this.soccerTransferRepository = soccerTransferRepository;
        this.soccerPlayerService = soccerPlayerService;
        this.soccerTeamService = soccerTeamService;
    }

    @Transactional
    public SoccerTransfer createTransfer(SoccerTransferRequest transferRequest) {
        logger.info("Creating transfer for player ID: {}", transferRequest.getSoccerPlayerId());

        SoccerPlayer player = soccerPlayerService.getPlayerById(transferRequest.getSoccerPlayerId());
        SoccerTeam fromTeam = player.getTeam();
        SoccerTeam toTeam = soccerTeamService.getTeamById(transferRequest.getToTeamId());

        if (fromTeam.getId().equals(toTeam.getId())) {
            throw new IllegalArgumentException("From team and to team cannot be the same.");
        }

        BigDecimal transferSum = TransferUtils.calculateSumOfTransfer(player, toTeam);

        if (transferSum.compareTo(toTeam.getBalance()) > 0) {
            throw new IllegalArgumentException("Team with ID: " + transferRequest.getToTeamId() +
                    " does not have enough funds to complete the transfer.");
        }

        fromTeam.setBalance(fromTeam.getBalance().add(transferSum));
        toTeam.setBalance(toTeam.getBalance().subtract(transferSum));
        player.setTeam(toTeam);

        SoccerTransfer soccerTransfer = new SoccerTransfer();
        soccerTransfer.setPlayer(player);
        soccerTransfer.setFromTeam(fromTeam);
        soccerTransfer.setToTeam(toTeam);
        soccerTransfer.setTransferSum(transferSum);

        return soccerTransferRepository.save(soccerTransfer);
    }


    public List<SoccerTransfer> getAllTransfers() {
        return soccerTransferRepository.findAll();
    }

    public Optional<SoccerTransfer> getTransferById(Long id) {
        return soccerTransferRepository.findById(id);
    }

}

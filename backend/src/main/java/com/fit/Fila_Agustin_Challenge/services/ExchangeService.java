package com.fit.Fila_Agustin_Challenge.services;

import com.fit.Fila_Agustin_Challenge.coinapi.CoinApiSvc;
import com.fit.Fila_Agustin_Challenge.coinapi.Exchange;
import com.fit.Fila_Agustin_Challenge.coinapi.ExchangeIcon;
import com.fit.Fila_Agustin_Challenge.models.ExchangeModel;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class ExchangeService {

    public List<ExchangeModel> top3Exchanges(String iconSize) throws IOException {
        List<Exchange> exchanges                    = CoinApiSvc.instancia().listarExchanges();
        List<ExchangeIcon> iconosExchanges          = CoinApiSvc.instancia().listarIconosExchanges(iconSize);
        Collections.sort(exchanges, Comparator.comparingDouble(e1 -> e1.getVolume_1mth_usd()));
        Collections.reverse(exchanges);
        List<Exchange> finalExchanges               = exchanges.subList(0,3);
        List<ExchangeModel> exchangeModels          = new ArrayList<ExchangeModel>();
        AtomicReference<Double> comisionExchange    = new AtomicReference<>(0.25);
        finalExchanges.forEach(unExchange -> {
            Optional<ExchangeIcon> opExchangeIcon =  Optional.of(iconosExchanges.stream().filter(unIcono ->
                    finalExchanges.stream().map(otroExchange ->
                        otroExchange.getExchange_id()).collect(Collectors.toList()).contains(unIcono.getExchange_id())).collect(Collectors.toList()).get(0));
            exchangeModels.add(
                    new ExchangeModel(
                            unExchange.getExchange_id(),
                            unExchange.getWebsite(),
                            unExchange.getName(),
                            comisionExchange.get(),
                            opExchangeIcon.isPresent() ? opExchangeIcon.get().getUrl() : ""));
            comisionExchange.updateAndGet(v -> v + 0.15);
        });
        return exchangeModels;
    }
}

package module13;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JsoupJsonTest {
    public static void main(String[] args) throws IOException {
        String url = "https://api.monobank.ua/bank/currency";
        String response = Jsoup.connect(url)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        Type type = TypeToken
                .getParameterized(List.class, CurrencyRateResponse.class)
                .getType();
        List<CurrencyRateResponse> currencyRateResponses = new Gson().fromJson(response, type);

        Map<Integer, String> currs = Map.of(
                980, "UAH",
                840, "USD",
                978, "EUR"
        );
        currencyRateResponses = currencyRateResponses.stream()
                .peek(item -> {
                    if (currs.containsKey(item.getCurrencyCodeA())) {
                        item.setCurrencySell(currs.get(item.getCurrencyCodeA()));
                    }
                })
                .filter(item -> item.getCurrencySell() != null)
                .collect(Collectors.toList());
        System.out.println("currencyRateResponses = " + currencyRateResponses);
    }
}

package app.model;

public enum Result {
    WIN("승"),
    LOSE("패"),
    TIE("무");

    private final String resultStr;

    Result(String resultStr) {
        this.resultStr = resultStr;
    }

    public String getResultStr() {
        return resultStr;
    }

}

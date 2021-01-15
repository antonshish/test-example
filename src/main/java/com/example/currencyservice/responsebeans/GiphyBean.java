package com.example.currencyservice.responsebeans;


public class GiphyBean {

    Data[] data;

    public GiphyBean(Data[] data) {
        this.data = data;
    }

    public GiphyBean() {
    }

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }

    public static class Data {
        private String embed_url;

        public Data(String embed_url) {
            this.embed_url = embed_url;
        }

        public Data() {
        }

        public String getEmbed_url() {
            return embed_url;
        }

        public void setEmbed_url(String embed_url) {
            this.embed_url = embed_url;
        }
    }
}

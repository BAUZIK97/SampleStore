package com.sampleStore.InternetStore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private int id;
    private String name;
    private float price;
    private int quantity;
}

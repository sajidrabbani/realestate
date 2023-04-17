package com.realestate.payload;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

@Data
public class SaleDto {
    private Long clientId;
    private Long agentId;
    private Long propertyId;

    @JsonFormat(pattern = "YYYY-MM-DD")
    private Date saleDate;


}
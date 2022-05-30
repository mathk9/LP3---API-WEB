package DAO;

import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

public class HashFunctions {
    
    private static HashFunctions instanceHash;

    public static HashFunctions getHashInstance() {
        if(instanceHash == null) {
            instanceHash = new HashFunctions();
        }
        return instanceHash;
    }   
    
    public String getHash(byte[] inputBytes, String algorithm){
        String hashValue = "";
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(inputBytes);
            byte[] digestedBytes = md.digest();
            hashValue = DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();
            
        } catch (Exception erro) {
            System.out.print("Erro Hash => "+erro);
        }
        
        return hashValue;
    }
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mahasiswa;

import java.util.Scanner;

public class Mahasiswa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        String nama,prodi,alamat;
        long nim;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Masukkan nama   :");
        nama= sc.nextLine();
       
        System.out.print("Masukkan NIM    :");
        nim= sc.nextLong();
        sc.nextLine();
                
        System.out.print("Masukkan Prodi  :");
        prodi= sc.nextLine();
        
        System.out.print("Masukkan Alamat :");
        alamat= sc.nextLine();
        
        System.out.println("BIODATA");
        System.out.println("Nama    :"+nama);
        System.out.println("NIM     :"+nim);
        System.out.println("Prodi   :"+prodi);
        System.out.println("Alamat  :"+alamat);
    }
    
}

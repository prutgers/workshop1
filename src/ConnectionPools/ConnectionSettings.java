/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionPools;

/**
 *
 * @author lucas
 */
public interface ConnectionSettings {
    public static final int NILL = 0;
    public static final int HIKARI = 1;
    public static final int C3P0 = 2;
    public static final int JDBCDRIVER = 3;
}

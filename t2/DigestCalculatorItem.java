package model;

import java.util.AbstractMap.SimpleEntry;

/*
 * Representa um parâmetro recebido via console, 
 * que posteriormente é calculado e reexibido na console
 */
public class DigestCalculatorItem
{
	public String _name;
	public SimpleEntry< String, byte[] > _digest;
    public Status _status;
}

package model;

import java.util.Optional;
import java.util.AbstractMap.SimpleEntry;

/*
 * Representa uma linha do arquivo que contém a lista de Digests
 */
public class DigestListFileItem
{
	public String _name;
	public SimpleEntry< String, byte[] > _digest1;
	public Optional< SimpleEntry< String, byte[] > > _digest2;
}

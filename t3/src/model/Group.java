package model;

/*
 * Possíveis grupos a qual um usuário pertence
 */
public enum Group
{
	Administrador, Usuário;

	private String _name;

	static
	{
		Administrador._name = "Administrador";
		Usuário._name = "Usuário";
	}

	public String getGroupName()
	{
		return _name;
	}
}
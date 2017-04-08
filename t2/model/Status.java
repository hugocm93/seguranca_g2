package model;

/*
 * Representa um status do item que é exibido no console
 */
public enum Status
{
	OK, NOT_OK, NOT_FOUND, COLLISION, NOT_DEFINED;

	private String _name;

	static
	{
		OK._name = "(OK)";
		NOT_OK._name = "(NOT OK)";
		NOT_FOUND._name = "(NOT FOUND)";
		COLLISION._name = "(COLLISION)";
		NOT_DEFINED._name = "(NOT_DEFINED)";
	}

	public String getStatusName()
	{
		return _name;
	}
}


class JogoDaVelha {
    private static String simbolo;
    private static Grid grid = new Grid();

    public static void main(String[] args) {
        mudarSimbolo();
    }

    public static String getSimbolo()
    {
        return simbolo;
    }

    public static void mudarSimbolo()
    {
        if(verificarVitoria())
        {
            grid.desabilitarBotoes();
            grid.popUp("☻ Vitória do " + simbolo);

            return;
        }

        if(verificarVelha())
        {
            grid.popUp("Opa, deu velha ☺");

            return;
        }

        if (simbolo == "X")
        {
            simbolo = "O";
        }
        else
        {
            simbolo = "X";
        }
    }

    private static boolean verificarVitoriaNasLinhas()
    {
        if (grid.getValorBotao(0) == simbolo && grid.getValorBotao(1) == simbolo && grid.getValorBotao(2) == simbolo)
        {
            return true;
        }

        if (grid.getValorBotao(3) == simbolo && grid.getValorBotao(4) == simbolo && grid.getValorBotao(5) == simbolo)
        {
            return true;
        }

        if (grid.getValorBotao(6) == simbolo && grid.getValorBotao(7) == simbolo && grid.getValorBotao(8) == simbolo)
        {
            return true;
        }

        return false;
    }

    private static boolean verificarVitoriaNasColunas()
    {
        if (grid.getValorBotao(0) == simbolo && grid.getValorBotao(3) == simbolo && grid.getValorBotao(6) == simbolo)
        {
            return true;
        }

        if (grid.getValorBotao(1) == simbolo && grid.getValorBotao(4) == simbolo && grid.getValorBotao(7) == simbolo)
        {
            return true;
        }

        if (grid.getValorBotao(2) == simbolo && grid.getValorBotao(5) == simbolo && grid.getValorBotao(8) == simbolo)
        {
            return true;
        }

        return false;
    }

    private static boolean verificarVitoriaNasDiagonais()
    {
        if (grid.getValorBotao(0) == simbolo && grid.getValorBotao(4) == simbolo && grid.getValorBotao(8) == simbolo)
        {
            return true;
        }

        if (grid.getValorBotao(2) == simbolo && grid.getValorBotao(4) == simbolo && grid.getValorBotao(6) == simbolo)
        {
            return true;
        }

        return false;
    }

    private static boolean verificarVitoria()
    {
        return verificarVitoriaNasLinhas() || verificarVitoriaNasColunas() || verificarVitoriaNasDiagonais();
    }

    private static boolean verificarVelha()
    {
        if(
                grid.getValorBotao(0) != ""
                        && grid.getValorBotao(1) != ""
                        && grid.getValorBotao(2) != ""
                        && grid.getValorBotao(3) != ""
                        && grid.getValorBotao(4) != ""
                        && grid.getValorBotao(5) != ""
                        && grid.getValorBotao(6) != ""
                        && grid.getValorBotao(7) != ""
                        && grid.getValorBotao(8) != ""
        )
        {
            return true;
        }

        return false;
    }
}
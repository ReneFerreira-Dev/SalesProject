import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        port(4567);

        
        staticFiles.location("/public"); 

        
        get("/", (req, res) -> {
            res.redirect("/index.html");
            return null;
        });

        
        post("/enviar", (req, res) -> {
            String nome = req.queryParams("nome");
            String posicao = req.queryParams("posicao");
            String empresa = req.queryParams("empresa");

            return "<html>" +
                    "<head><meta charset='UTF-8'><title>Resultado</title></head>" +
                    "<body style='font-family: Arial;'>" +
                    "<h2>Dados Inseridos:</h2>" +
                    "<p><strong>1. Nome:</strong> " + nome + "</p>" +
                    "<p><strong>2. Posição:</strong> " + posicao + "</p>" +
                    "<p><strong>3. Empresa:</strong> " + empresa + "</p>" +
                    "<br><a href='/index.html'>Voltar</a>" +
                    "</body></html>";
        });
    }
}

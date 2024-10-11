package br.ulbra.cadastro;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

public class MainActivity extends Activity {
    private ArrayList<Registro> aRegistro;
    private Button btcadastrar_usuario, bt_listar_usuarios_cadastrados;
    private TelaCadastroUsuario tela_cadastro;
    private TelaListagemUsuarios tela_listagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        aRegistro = new ArrayList<>();

        // Inicializa as telas de cadastro e listagem
        tela_cadastro = new TelaCadastroUsuario(this);
        tela_listagem = new TelaListagemUsuarios(this);

        // Carrega a tela principal
        carregarTelaPrincipal();
    }

    public void carregarTelaPrincipal() {
        setContentView(R.layout.activity_main);
        btcadastrar_usuario = findViewById(R.id.btcadastrar_usuario);
        bt_listar_usuarios_cadastrados = findViewById(R.id.bt_listar_usuarios_cadastrados);

        btcadastrar_usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela_cadastro.carregarTela();
            }
        });

        bt_listar_usuarios_cadastrados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela_listagem.carregarTela();
            }
        });
    }

    public ArrayList<Registro> getRegistros() {
        return aRegistro;
    }

    public void exibirMensagem(String msg) {
        AlertDialog.Builder d = new AlertDialog.Builder(MainActivity.this);
        d.setTitle("Aviso");
        d.setMessage(msg);
        d.setNeutralButton("OK", null);
        d.show();
    }
}

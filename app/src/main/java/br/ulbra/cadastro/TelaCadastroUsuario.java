package br.ulbra.cadastro;

import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog;

public class TelaCadastroUsuario {
    private MainActivity act;
    private EditText edNome, edEndereco, edTelefone;
    private Button btCadastrar, btCancelarCadastro;

    public TelaCadastroUsuario(MainActivity act) {
        this.act = act;
    }

    public void carregarTela() {
        act.setContentView(R.layout.cadastro_de_usuarios);
        edNome = act.findViewById(R.id.ednome);
        edTelefone = act.findViewById(R.id.edtelefone);
        edEndereco = act.findViewById(R.id.edendereco);
        btCadastrar = act.findViewById(R.id.btcadastrar);
        btCancelarCadastro = act.findViewById(R.id.btcancelar_cadastro);

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogo = new AlertDialog.Builder(act);
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Cadastrar usuário?");
                dialogo.setNegativeButton("Não", null);
                dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String nome = edNome.getText().toString();
                        String telefone = edTelefone.getText().toString();
                        String endereco = edEndereco.getText().toString();
                        act.getRegistros().add(new Registro(nome, telefone, endereco));
                        act.exibirMensagem("Cadastro efetuado com sucesso.");
                        act.carregarTelaPrincipal(); // Navega de volta para a tela principal
                    }
                });
                dialogo.show();
            }
        });

        btCancelarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogo = new AlertDialog.Builder(act);
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Sair do cadastro?");
                dialogo.setNegativeButton("Não", null);
                dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        act.carregarTelaPrincipal(); // Navega de volta para a tela principal
                    }
                });
                dialogo.show();
            }
        });
    }
}

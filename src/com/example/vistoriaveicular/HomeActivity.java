package com.example.vistoriaveicular;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;

import android.R.menu;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import models.Vistoria;

public class HomeActivity extends FragmentActivity {
	public static final ArrayList<Vistoria> vistorias = new ArrayList<Vistoria>();
	public static Boolean edita = false;
	public static int idParaEditar = 0;
	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	static SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	static ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);		
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

		    @Override
		    public void onPageSelected(int position) {
		    	if(position==0){
		    		if(edita){
		    			Vistoria vistoriaParaEditar = vistorias.get(idParaEditar);
		    			EditText txtCPF = (EditText)findViewById(R.id.edtCpf);
						txtCPF.setText(vistoriaParaEditar.getCpf().toString());
						EditText txtNome = (EditText)findViewById(R.id.edtNomeProprietario);
						txtNome.setText(vistoriaParaEditar.getNome().toString());
						EditText txtEndereco = (EditText)findViewById(R.id.edtEndereco);
						txtEndereco.setText(vistoriaParaEditar.getEndereco().toString());
						EditText txtPlaca = (EditText)findViewById(R.id.edtPlacaVeiculo);
						txtPlaca.setText(vistoriaParaEditar.getPlaca().toString());
						EditText txtMarca = (EditText)findViewById(R.id.edtMarcaModelo);
						txtMarca.setText(vistoriaParaEditar.getMarca().toString());
						RadioButton boolAprovado = (RadioButton)findViewById(R.id.rdAprovado);
						if(vistoriaParaEditar.getAprovado().booleanValue()){
							boolAprovado.setChecked(true);
						}else{
							RadioButton boolReprovado = (RadioButton)findViewById(R.id.rdAprovado);
							boolReprovado.setChecked(true);
						}
						boolAprovado.setVisibility(1);
						EditText txtObservacao = (EditText)findViewById(R.id.edtObservacao);
						txtObservacao.setText(vistoriaParaEditar.getObservacao().toString());
						txtObservacao.setVisibility(1);
						TextView txtvObservacao = (TextView)findViewById(R.id.txtObservacao);
						txtvObservacao.setVisibility(1);
						TextView txtAprovado = (TextView)findViewById(R.id.txtAprovado);
						txtAprovado.setVisibility(1);
						RadioGroup rdgAprovado = (RadioGroup)findViewById(R.id.rdGpAprovado);
						rdgAprovado.setVisibility(1);
		    		}else{
		    			RadioButton boolAprovado = (RadioButton)findViewById(R.id.rdAprovado);
						boolAprovado.setVisibility(0);
						EditText txtObservacao = (EditText)findViewById(R.id.edtObservacao);
						txtObservacao.setVisibility(0);
						TextView txtvObservacao = (TextView)findViewById(R.id.txtObservacao);
						txtvObservacao.setVisibility(0);
						TextView txtAprovado = (TextView)findViewById(R.id.txtAprovado);
						txtAprovado.setVisibility(0);
						RadioGroup rdgAprovado = (RadioGroup)findViewById(R.id.rdGpAprovado);
						rdgAprovado.setVisibility(0);
						edita=false;
		    		}
		    	}else if(position==1){
		    		ListView listaVistorias = (ListView)findViewById(R.id.listCadastro);
					
					ArrayAdapter<Vistoria> adapter = new ArrayAdapter<Vistoria>(getBaseContext(),android.R.layout.simple_list_item_1, vistorias);
					listaVistorias.setAdapter(adapter);
		    	}
		    }

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}		    
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}
		
		@Override
		public Fragment getItem(int position) {
			if (position == 0) {
				Fragment fragment = new CadastroSectionFragment();
				Bundle args = new Bundle();
				args.putInt(CadastroSectionFragment.ARG_SECTION_NUMBER,position);
				fragment.setArguments(args);
				return fragment;
			} else if (position == 1) {
				Fragment fragment = new ListaSectionFragment();
				Bundle args = new Bundle();
				args.putInt(ListaSectionFragment.ARG_SECTION_NUMBER,position);
				fragment.setArguments(args);
				return fragment;
			} else if(position == 2) {
				Fragment fragment = new AvaliacaoSectionFragment();
				Bundle args = new Bundle();
				args.putInt(AvaliacaoSectionFragment.ARG_SECTION_NUMBER,position);
				fragment.setArguments(args);
				return fragment;
			}
			Fragment fragment = new Fragment();
			return fragment;
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.txtCadastro).toUpperCase(l);
			case 1:
				return getString(R.string.txtLista).toUpperCase(l);
			case 2:
				return getString(R.string.txtAvaliacao).toUpperCase(l);
			}
			return null;
		}	
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class ListaSectionFragment extends Fragment {
		public static final String ARG_SECTION_NUMBER = "section_number";
		public ListaSectionFragment() {			
		}
		
		public void editVistoria(int nVistoria){
			edita = true;
			idParaEditar = nVistoria;
    		mViewPager.setCurrentItem(0);
		}
			
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_home_lista,container, false);
			ListView listaVistorias = (ListView)rootView.findViewById(R.id.listCadastro);
			listaVistorias.setOnItemClickListener(new OnItemClickListener() {
				@Override
				  public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
					 editVistoria(position);
				  }
			});
			
			ArrayAdapter<Vistoria> adapter = new ArrayAdapter<Vistoria>(getActivity(),android.R.layout.simple_list_item_1, vistorias);
			listaVistorias.setAdapter(adapter);
			return rootView;
		}
	}
	
	
	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class AvaliacaoSectionFragment extends Fragment {
		public static final String ARG_SECTION_NUMBER = "section_number";
		public AvaliacaoSectionFragment() {}
		
		
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_home_avaliacao,container, false);
			Button btnCancelar = (Button) rootView.findViewById(R.id.button1);
			btnCancelar.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Toast t = Toast.makeText(getActivity(), "Obrigado querido professor por avaliar o app de Vistoria Veicular!", Toast.LENGTH_LONG);
					Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
					emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Obrigado querido professor por avaliar o app de Vistoria Veicular!");
					startActivity(Intent.createChooser(emailIntent, "Send someone an email..."));
					t.show();				
				}
			});
			
			return rootView;
		}
	}
	

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class CadastroSectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public CadastroSectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
			final View rootView = inflater.inflate(R.layout.fragment_home_cadastro,container, false);
			Button btnEnviar = (Button) rootView.findViewById(R.id.btnEnviar);
			Button btnCancelar = (Button) rootView.findViewById(R.id.btnCancelar);
			btnCancelar.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					EditText txtCPF = (EditText)rootView.findViewById(R.id.edtCpf);
					EditText txtNome = (EditText)rootView.findViewById(R.id.edtNomeProprietario);
					EditText txtEndereco = (EditText)rootView.findViewById(R.id.edtEndereco);
					EditText txtPlaca = (EditText)rootView.findViewById(R.id.edtPlacaVeiculo);
					EditText txtMarca = (EditText)rootView.findViewById(R.id.edtMarcaModelo);
					RadioButton boolAprovado = (RadioButton)rootView.findViewById(R.id.rdAprovado);
					EditText observacao = (EditText)rootView.findViewById(R.id.edtObservacao);
					txtCPF.setText("");
					txtNome.setText("");
					txtEndereco.setText("");
					txtPlaca.setText("");
					txtMarca.setText("");
					boolAprovado.setChecked(true);
					observacao.setText("");
				}
			});
			btnEnviar.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					EditText txtCPF = (EditText)rootView.findViewById(R.id.edtCpf);
					Long cpf = Long.parseLong(txtCPF.getText().toString());
					EditText txtNome = (EditText)rootView.findViewById(R.id.edtNomeProprietario);
					String nome = txtNome.getText().toString();
					EditText txtEndereco = (EditText)rootView.findViewById(R.id.edtEndereco);
					String endereco = txtEndereco.getText().toString();
					EditText txtPlaca = (EditText)rootView.findViewById(R.id.edtPlacaVeiculo);
					String placa = txtPlaca.getText().toString();
					EditText txtMarca = (EditText)rootView.findViewById(R.id.edtMarcaModelo);
					String marca = txtMarca.getText().toString();
					RadioButton boolAprovado = (RadioButton)rootView.findViewById(R.id.rdAprovado);
					Boolean aprovado = boolAprovado.isChecked();
					EditText observacao = (EditText)rootView.findViewById(R.id.edtObservacao);
					String obs = observacao.getText().toString();
					Vistoria novaVistoria = new Vistoria(cpf,nome,endereco,placa,marca,aprovado,obs);
					if(edita){
						vistorias.set(idParaEditar, novaVistoria);
						idParaEditar=0;
						edita=false;
					}else{
						vistorias.add(novaVistoria);
					}
					txtCPF.setText("");
					txtNome.setText("");
					txtEndereco.setText("");
					txtPlaca.setText("");
					txtMarca.setText("");
					boolAprovado.setChecked(true);
					observacao.setText("");
					Toast t = Toast.makeText(getActivity(), "Vistoria registrada com sucesso!", Toast.LENGTH_SHORT);
					mViewPager.setCurrentItem(1);
					t.show();
				}
			});
			return rootView;
		}
	}
}
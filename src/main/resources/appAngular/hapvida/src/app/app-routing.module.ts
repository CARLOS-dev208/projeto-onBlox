import { ClienteCreateComponent } from './components/cliente/cliente-create/cliente-create.component';
import { ClienteCrudComponent } from './pages/cliente-crud/cliente-crud.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProdutosCrudComponent } from './pages/produtos-crud/produtos-crud.component';
import { VendedoresCrudComponent } from './pages/vendedores-crud/vendedores-crud.component';
import { ProdutosCreateComponent } from './components/produtos/produtos-create/produtos-create.component';
import { VendedoresCreateComponent } from './components/vendedores/vendedores-create/vendedores-create.component';

const routes: Routes = [
  { path: 'clientes', component: ClienteCrudComponent },
  { path: 'clientes/create', component: ClienteCreateComponent },
  { path: 'vendedores', component: VendedoresCrudComponent },
  { path: 'vendedores/create', component: VendedoresCreateComponent },
  { path: 'produtos', component: ProdutosCrudComponent },
  { path: 'produtos/create', component: ProdutosCreateComponent },
  { path: '', redirectTo: 'vendedores', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

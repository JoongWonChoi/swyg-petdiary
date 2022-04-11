import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import { GlobalStyles} from "./styles";
import { HelmetProvider } from "react-helmet-async";
import Home from "./screens/Home";
import Login from "./screens/Login";
import SignUp from "./screens/SignUp";
import routes from "./routes";
import NotFound from "./screens/NotFound";

const isLoggedIn=false;

function App() {
  <HelmetProvider>
  
    <GlobalStyles/>
    <Router>
      <Switch>
        <Route path={routes.home} exact>
          {isLoggedIn ? <Home /> : <Login />}
        </Route>
        
        {!isLoggedIn ? (<Route path={routes.signUp}>  <SignUp /> </Route>) : null}
        
        <Route>
          <NotFound />    {/*불가한url일때 보내는 페이지*/}
        </Route>
      </Switch>
    </Router>
</HelmetProvider>
}

export default App;

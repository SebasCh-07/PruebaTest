import { StyleSheet, Text, View, Button, TouchableOpacity, FlatList } from 'react-native';
import { serviciosRecuperarRuta } from './services/TestServices'

const [ruta, setRuta] = useState([]);

const serviciosRecuperarRuta = () => {
    let Rutas = []
    fetch("http://192.168.163.153:8080/EvaluacionModuloIII-1.0.0/rest/rutas/recuperar").then((response) => {response.json()}).then((json) => {Rutas = json})
    setRuta(Rutas);
}

export const Ruta = ({ navigation }) => {
    return (<View style={styles.container}>
        <View style={styles.areaTitulo}>
            <Text style={styles.titulo}>ListasBuses</Text>
        </View>

        <View style={styles.areaContenido}>
            <FlatList
                data={ruta}
                renderItem={() => {
                    <View>
                        <Text>{ruta.codigor}</Text>
                    </View>
                }}
                  
            />
        </View>

        <View style={styles.areaBotones}>
            <TouchableOpacity
                style={styles.boton}
                onPress={() => {
                    navigation.navigate("InsertarBuses");
                }}
            >
                <Text style={styles.textoBoton}>Agregar Buses</Text>
            </TouchableOpacity>
            <TouchableOpacity
                style={styles.boton}
                onPress={() => {
                    navigation.navigate("insertarRutas");
                }}
            >
                <Text style={styles.textoBoton}>Ingresar ruta</Text>
            </TouchableOpacity>
            <TouchableOpacity
                style={styles.boton}
                onPress={() => {
                  navigation.navigate("listasBuses");
              }}
            >
                <Text style={styles.textoBoton}>Buses Disponibles</Text>
            </TouchableOpacity>

        </View>
    </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff',
        flexDirection: "column",
        alignItems: 'center',
        justifyContent: 'center',
        padding: 20
    },
    areaBotones: {
      flex: 2,
      flexDirection: 'column',
      marginBottom: 10,
      justifyContent: 'center',
      alignItems: 'flex-start',
     // backgroundColor: "#ecfcd0",
    },
    titulo: {
        fontSize: 20,
        fontWeight: 'bold',
    },
    areaTitulo: {
        flex: 1,
        margin: 10,
        justifyContent: 'flex-end',
        alignItems: "center",
        //backgroundColor: "skyblue"
    },
    boton: {
        backgroundColor: '#4CAF50',
        padding: 10,
        margin: 10,
        borderRadius: 5,
    },
    textoBoton: {
        color: 'white',
        textAlign: 'center',
        fontSize: 16,
    },
    areaContenido: {
        flex: 6,
        //backgroundColor: "lightblue",
      },
});
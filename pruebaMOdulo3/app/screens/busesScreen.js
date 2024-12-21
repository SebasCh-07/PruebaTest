import { StyleSheet, Text, View, Button, TouchableOpacity, FlatList } from 'react-native';

export const Ruta = ({ navigation }) => {
    return (<View style={styles.container}>
        <View style={styles.areaTitulo}>
            <Text style={styles.titulo}>BUSES</Text>
        </View>

        <FlatList
            
        />

        <View style={styles.areaBotones}>
            <TouchableOpacity
                style={styles.boton}
                onPress={() => {
                    navigation.navigate("InsertarBuses");
                } }
            >
                <Text style={styles.textoBoton}>Agregar Buses</Text>
            </TouchableOpacity>
            <TouchableOpacity
                style={styles.boton}
                onPress={() => {
                    navigation.navigate("insertarRutas");
                } }
            >
                <Text style={styles.textoBoton}>Ingresar ruta</Text>
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
      flexDirection: 'row',
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
    }
  });
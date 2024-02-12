# ElytraDisabler

ElytraDisabler is a Bukkit/Spigot plugin designed to disable elytra usage under certain conditions. It includes features to monitor server memory usage for possible memory leaks.

## Features

- **Elytra Disabling**: Prevents players from using elytra under specified conditions.
- **Memory Monitoring**: Monitors server memory usage and detects possible memory leaks (Temporary).

## Installation

1. Download the latest release from the [releases page](https://github.com/XinTheta/ElytraDisabler/releases/).
2. Place the downloaded `ElytraDisabler.jar` file into the `plugins` folder of your Bukkit/Spigot server.
3. Restart your server to load the plugin.

## Configuration

The plugin comes with a default configuration file (`config.yml`) located in the `plugins/ElytraDisabler` directory. You can customize the plugin's behavior by modifying this file.

### Example Configuration

```yaml
# Do not edit the config version
config-version: 1

# Enable / Disable the plugin
disable-elytra: true

# Main feature to not let the user pickup the elytra
disable-elytra-pickup: true

# All of these are layers of disabling the elytra
# In case if a player finds a way to equip the elytra
# the following will not let him proceed further

# Disable gliding with elytra
disable-gliding: true

# Disable interactions with elytra
disable-elytra-interaction: true

# Players cant wear elytra using dispensers
dispenser-fix: true
```


## Commands
- **/elytradisabler reload**: Reloads the plugin's configuration from the `config.yml` file.

## Permissions
- **elytradisabler.reload**: Allows players to reload the plugin's configuration.

## Contributing
If you encounter any bugs or have suggestions for improvements, please [open an issue](https://github.com/XinTheta/ElytraDisabler/issues) on GitHub.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.


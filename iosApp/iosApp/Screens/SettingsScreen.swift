import SwiftUI

struct SettingsScreen: View {
    var body: some View {
        VStack(alignment: .leading, spacing: 0) {
            Text("Settings")
                .font(.title2)
                .fontWeight(.bold)
                .padding(.bottom, 16)

            SettingItem(title: "Accounts", systemIcon: "person")
            Divider()
            SettingItem(title: "Notifications", systemIcon: "bell")
            Divider()
            SettingItem(title: "About", systemIcon: "info.circle")
            Divider()
            SettingItem(title: "Help", systemIcon: "phone")
        }
        .padding(16)
        .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .topLeading)
    }
}

struct SettingItem: View {
    let title: String
    let systemIcon: String

    var body: some View {
        HStack {
            Image(systemName: systemIcon)
                .foregroundColor(.blue)
                .frame(width: 24, height: 24)

            Spacer().frame(width: 16)

            Text(title)
                .font(.body)
                .fontWeight(.medium)

            Spacer()
        }
        .padding(.vertical, 12)
        .contentShape(Rectangle())
        .onTapGesture {
            // Handle tap
        }
    }
}

#Preview {
    SettingsScreen()
}
